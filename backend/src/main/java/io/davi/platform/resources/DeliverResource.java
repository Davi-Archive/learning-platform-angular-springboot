package io.davi.platform.resources;

import io.davi.platform.dto.DeliverResivionDTO;
import io.davi.platform.entities.Deliver;
import io.davi.platform.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService service;

    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverResivionDTO dto){
        service.saveRevision(id,dto);
        return ResponseEntity.noContent().build();
    }
}
