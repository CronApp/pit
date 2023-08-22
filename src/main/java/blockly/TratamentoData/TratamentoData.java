package blockly.TratamentoData;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TratamentoData {

public static final int TIMEOUT = 300;

/**
 *
 * @author Wesley Miranda De Oliveira
 * @since 22/08/2023, 09:30:21
 *
 */
@RequestMapping(path = "/api/cronapi/rest/TratamentoData.TratamentoData:ResultadoData", method = RequestMethod.GET, consumes = "*/*")
public static Var ResultadoData() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return Var.VAR_NULL;
   }
 }.call();
}

}

