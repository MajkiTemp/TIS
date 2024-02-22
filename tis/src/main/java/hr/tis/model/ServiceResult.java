package hr.tis.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceResult {
     Boolean success;
     String message;
     Object object;
    public ServiceResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public ServiceResult(Boolean success, String message,Object object) {
        this.success = success;
        this.message = message;
        this.object = object;

    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            object =mapper.writeValueAsString(object);
        }
        catch (JsonProcessingException e) {
            return "ServiceResult [Success=False, message=Error while mapping object]";
        }
        return "ServiceResult [Success=" + success + ", message=" + message + ",object="+object+"]";
    }

}

