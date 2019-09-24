package app.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.model.Equipo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class EquipoStorage {
    private ObjectMapper objectMapper;
    public EquipoStorage(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }
    public List<Equipo> equipos(){
        try{
            return objectMapper.readValue
                    (new File("/Users/Marina/quidditch/src/main/resources/equipos.json"),
                            new TypeReference<List<Equipo>>(){}
                    );
        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
