package pdev.com.agenda.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;

import java.util.ArrayList;
import java.util.List;

@Component // preciso colocar como um component agroa que estou usando model mapper
@RequiredArgsConstructor // preciso dessa ajuda do lombok para usar o modelmapper
public class PacienteMapper {


    private final ModelMapper mapper;

    public Paciente toPaciente{

    }

//    public static Paciente toPaciente(PacienteRequest request) {
//        Paciente paciente = new Paciente();
//        paciente.setNome(request.getNome());
//        paciente.setSobrenome(request.getSobrenome());
//        paciente.setEmail(request.getEmail());
//        paciente.setCpf(request.getCpf());
//
//        return paciente;
//
//    }

    public static PacienteResponse toPacienteResponse(Paciente paciente) {
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setSobrenome(paciente.getSobrenome());
        response.setEmail(paciente.getEmail());
        response.setCpf(paciente.getCpf());

        return response;

    }

    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
        // crio lista vazio
        List<PacienteResponse> responses = new ArrayList<>();
        // itero para adicionar a nova lista os pacientes response
        for (Paciente paciente : pacientes){
            //usando o proprio metodo de response
            responses.add(toPacienteResponse(paciente));
        }

        return responses;

    }
}
