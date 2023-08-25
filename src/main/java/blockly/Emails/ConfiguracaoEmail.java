package blockly.Emails;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ConfiguracaoEmail {

public static final int TIMEOUT = 300;

/**
 *
 * Descreva esta função...
 *
 * @author Matheus Portugal Ribeiro
 * @since 27/02/2023, 11:15:11
 *
 */
public static void AntesAtualizar() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    if (
    Var.valueOf(
    Var.valueOf(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("ConfiguracaoAmbiente.active.ativo")).equals(
    Var.VAR_TRUE)).getObjectAsBoolean() ||
    Var.valueOf(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("ConfiguracaoAmbiente.active.ativo")).equals(
    Var.valueOf("true"))).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.ConfiguracaoAmbiente"), Var.valueOf("update \n	ConfiguracaoAmbiente  \nset \n	ativo = :ativo"),Var.valueOf("ativo",
        Var.VAR_FALSE));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @author Matheus Portugal Ribeiro
 * @since 27/02/2023, 11:15:11
 *
 */
public static void AntesInserir() throws Exception {
  new Callable<Var>() {

   public Var call() throws Exception {
    if (
    Var.valueOf(
    Var.valueOf(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("ConfiguracaoAmbiente.active.ativo")).equals(
    Var.VAR_TRUE)).getObjectAsBoolean() ||
    Var.valueOf(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("ConfiguracaoAmbiente.active.ativo")).equals(
    Var.valueOf("true"))).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.ConfiguracaoAmbiente"), Var.valueOf("update \n	ConfiguracaoAmbiente  \nset \n	ativo = :ativo"),Var.valueOf("ativo",
        Var.VAR_FALSE));
    }
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("ConfiguracaoAmbiente.active.id"),
    cronapi.util.Operations.generateUUID());
   return Var.VAR_NULL;
   }
 }.call();
}

}

