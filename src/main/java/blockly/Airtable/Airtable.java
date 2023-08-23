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
 * @author Wesley Miranda De Oliveira
 * @since 23/08/2023, 09:05:04
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
    Var.valueOf("appv3oU8pw6zwPloY");
    tableId =
    Var.valueOf("tblBvAruXcbmk7k4Q");
    retorno =
    cronapi.util.Operations.getURLFromOthers(
    Var.valueOf("GET"),
    Var.valueOf("application/json"),
    Var.valueOf(
    Var.valueOf("https://api.airtable.com/").getObjectAsString() +
    versao.getObjectAsString() +
    cronapi.io.Operations.fileSeparator().getObjectAsString() +
    baseId.getObjectAsString() +
    cronapi.io.Operations.fileSeparator().getObjectAsString() +
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
 * @author Wesley Miranda De Oliveira
 * @since 23/08/2023, 09:05:04
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
    Var.valueOf("patQD4h9Gs9PqWnSY.0053f319b8c4017d22f43f800b7eb918ca97f05d34c21a4df18f98df4ea1a664").getObjectAsString())));
    return item;
   }
 }.call();
}

}

