package lk.ijse.documentproofservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import lk.ijse.documentproofservice.dto.DeliveryProofDTO;
import lk.ijse.documentproofservice.entity.DeliveryProof;
import lk.ijse.documentproofservice.repo.DeliveryProofRepository;
import lk.ijse.documentproofservice.service.DeliveryProofService;
import lk.ijse.documentproofservice.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryProofServiceImpl implements DeliveryProofService {

    @Autowired
    private DeliveryProofRepository repo;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public int saveProof(DeliveryProofDTO dto) {
        try {

            DeliveryProof proof =
                    objectMapper.convertValue(dto, DeliveryProof.class);

            proof.setUploadedAt(LocalDateTime.now());

            repo.save(proof);

            return VarList.Created;

        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Internal_Server_Error;
        }
    }

    @Override
    public Object getByOrderCode(String orderCode) {
        try {

            if (!repo.existsByOrderCode(orderCode)) {
                return VarList.Not_Found;
            }

            return repo.findByOrderCode(orderCode);

        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Internal_Server_Error;
        }
    }
}