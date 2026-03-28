package lk.ijse.documentproofservice.service;


import lk.ijse.documentproofservice.dto.DeliveryProofDTO;

public interface DeliveryProofService {

    int saveProof(DeliveryProofDTO dto);

    Object getByOrderCode(String orderCode);
}