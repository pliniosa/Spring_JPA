package me.dio.academia.digital.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServeceImpl implements IAlunoService{

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {
        // TODO Auto-generated method stub
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return repository.save(aluno);

    }

    @Override
    public Aluno get(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        // TODO Auto-generated method stub
        if(dataDeNascimento == null){
            return repository.findAll();
        }else{
            LocalDate localdate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localdate);
        }
        
        
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        repository.delete(repository.findById(id).get());
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicasId(Long id) {
        // TODO Auto-generated method stub
        Aluno aluno = repository.findById(id).get();
        return aluno.getAvaliacoes();
    }


}
