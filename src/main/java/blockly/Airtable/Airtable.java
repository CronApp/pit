package blockly.Airtable;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Airtable {

public static final int TIMEOUT = 300;

/**
 *
 * @author Thiago Costa
 * @since 22/01/2024, 14:15:31
 *
 */
public static Var GetApi() throws Exception {
 return new Callable<Var>() {

   private Var versao = Var.VAR_NULL;
   private Var baseId = Var.VAR_NULL;
   private Var tableId = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;

   public Var call() throws Exception {
    versao =
    Var.valueOf("v0");
    baseId =
    cronapi.util.Operations.getSystemParameter(
    Var.valueOf("baseId"));
    tableId =
    cronapi.util.Operations.getSystemParameter(
    Var.valueOf("tableId"));
    retorno =
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/json"),
    Var.valueOf(
    Var.valueOf("https://api.airtable.com/").getObjectAsString() +
    versao.getObjectAsString() +
    Var.valueOf("/").getObjectAsString() +
    baseId.getObjectAsString() +
    Var.valueOf("/").getObjectAsString() +
    tableId.getObjectAsString()), Var.VAR_NULL,
    Var.valueOf(airtableApi()), Var.VAR_NULL,
    Var.valueOf(""),
    Var.valueOf("ALL"));
    return
cronapi.json.Operations.toJson(
cronapi.util.Operations.getItemFromHttpResponse(retorno,
Var.valueOf("BODY")));
   }
 }.call();
}

/**
 *
 * @author Thiago Costa
 * @since 22/01/2024, 14:15:31
 *
 */
public static Var airtableApi() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("Authorization",
    Var.valueOf(
    Var.valueOf("Bearer ").getObjectAsString() +
    cronapi.util.Operations.getSystemParameter(
    Var.valueOf("token_api")).getObjectAsString())));
    return item;
   }
 }.call();
}

}

