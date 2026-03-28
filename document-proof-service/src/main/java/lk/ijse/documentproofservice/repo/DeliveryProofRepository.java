package lk.ijse.documentproofservice.repo;


import lk.ijse.documentproofservice.entity.DeliveryProof;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeliveryProofRepository extends MongoRepository<DeliveryProof, String> {

    List<DeliveryProof> findByOrderCode(String orderCode);
    boolean existsByOrderCode(String orderCode);
}