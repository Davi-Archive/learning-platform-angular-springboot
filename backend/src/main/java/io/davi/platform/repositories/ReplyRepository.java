package io.davi.platform.repositories;

import io.davi.platform.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
}
