package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findAllById(form.getAlunoId().get());

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long Id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getALL(String bairro) {
        if(bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.findAlunoMatriculadosBairro(bairro);
        }
    }


    public Matricula create(MatriculaForm form) {
    }
}
