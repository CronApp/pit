package blockly.TratamentoData;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TratamentoData {

public static final int TIMEOUT = 300;

/**
 *
 * @author Wesley Miranda De Oliveira
 * @since 21/08/2023, 17:06:58
 *
 */
public static Var ResultadoData() throws Exception {
 return new Callable<Var>() {

   private Var dataAtual = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;

   public Var call() throws Exception {
    dataAtual =
    cronapi.dateTime.Operations.getNowNoHour();
    if (
    Var.valueOf(
    cronapi.dateTime.Operations.getNowNoHour().compareTo(
    cronapi.dateTime.Operations.newDate(
    Var.valueOf(2023),
    Var.valueOf(11),
    Var.valueOf(25),
    Var.VAR_NULL,
    Var.VAR_NULL,
    Var.VAR_NULL)) < 0).getObjectAsBoolean()) {
        retorno =
        Var.VAR_FALSE;
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.disableComponent"),
        Var.valueOf("div-resultado-rank-id"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
        Var.valueOf("div-resultado-rank-id"),
        Var.valueOf("false"));
    } else {
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.disableComponent"),
        Var.valueOf("id-resultado-info-data"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.setVisibility"),
        Var.valueOf("id-resultado-info-data"),
        Var.valueOf("false"));
        retorno =
        Var.VAR_TRUE;
    }
    return retorno;
   }
 }.call();
}

}

