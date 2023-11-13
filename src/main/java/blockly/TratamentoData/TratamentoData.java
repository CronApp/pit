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
 * @author José Zay
 * @since 10/11/2023, 16:52:54
 *
 */
@RequestMapping(path = "/api/cronapi/rest/TratamentoData.TratamentoData:ResultadoData", method = RequestMethod.GET, consumes = "*/*")
public static Var ResultadoData() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
Var.valueOf(
cronapi.dateTime.Operations.getNowNoHour().compareTo(
cronapi.dateTime.Operations.newDate(
Var.valueOf(2023),
Var.valueOf(12),
Var.valueOf(1),
Var.VAR_NULL,
Var.VAR_NULL,
Var.VAR_NULL)) >= 0);
   }
 }.call();
}

}

