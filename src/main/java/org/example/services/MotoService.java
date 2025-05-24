package org.example.services;

import org.example.domainmodel.Moto;
import org.example.repositories.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    private final MotoRepository motoRepository;

    @Autowired
    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public Moto salvar(Moto moto) {
        if (motoRepository.existsByPlaca(moto.getPlaca())) {
            throw new IllegalArgumentException("Já existe uma moto com esta placa.");
        }
        return motoRepository.save(moto);
    }

    public Moto buscarPorId(Long id) {
        return motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada com ID: " + id));
    }

    public List<Moto> listarTodas() {
        return motoRepository.findAll();
    }

    public Moto atualizar(Long id, Moto dadosAtualizados) {
        Moto existente = buscarPorId(id);
        existente.setPlaca(dadosAtualizados.getPlaca());
        existente.setModelo(dadosAtualizados.getModelo());
        existente.setAno(dadosAtualizados.getAno());
        existente.setCor(dadosAtualizados.getCor());
        return motoRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new RuntimeException("Moto não encontrada para deletar com ID: " + id);
        }
        motoRepository.deleteById(id);
    }
}
