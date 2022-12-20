package pdev.com.agenda.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pdev.com.agenda.api.request.PacienteRequest;
import pdev.com.agenda.api.response.PacienteResponse;
import pdev.com.agenda.domain.entity.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component // preciso colocar como um component agroa que estou usando model mapper
@RequiredArgsConstructor // preciso dessa ajuda do lombok para usar o modelmapper
public class PacienteMapper {


    private final ModelMapper mapper;

    public Paciente toPaciente(PacienteRequest request){
        Paciente paciente = mapper.map(request, Paciente.class);
        return paciente;
    }

    public PacienteResponse toPacienteResponse(Paciente paciente){
        return mapper.map(paciente, PacienteResponse.class);
    }

    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
        // for em cada paciente da lista de paciente
        // para cada um ele passa para o metodo
        // e no fim passa tudo para uma nova lista
        return pacientes.stream()
                .map(this::toPacienteResponse)
                .collect(Collectors.toList());
    }

// forma antiga de fazer o mapper sem o modal mapper

//    public static List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
//        // crio lista vazio
//        List<PacienteResponse> responses = new ArrayList<>();
//        // itero para adicionar a nova lista os pacientes response
//        for (Paciente paciente : pacientes){
//            //usando o proprio metodo de response
//            responses.add(toPacienteResponse(paciente));
//        }
//
//        return responses;
//
//    }
}
