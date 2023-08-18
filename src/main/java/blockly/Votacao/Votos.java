package blockly.Votacao;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Votos {

public static final int TIMEOUT = 300;

/**
 *
 * @param idItemVoto
 *
 * @author Wesley Miranda De Oliveira
 * @since 18/08/2023, 09:37:11
 *
 */
public static Var FinalizarVoto(@ParamMetaData(description = "idItemVoto", id = "fb0d967d") Var idItemVoto) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    cronapi.database.Operations.query(Var.VAR_NULL,Var.VAR_NULL).getObjectAsBoolean()) {
        item =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.ControleVotacao"),Var.valueOf("user",
        cronapi.util.Operations.getCurrentUserName()),Var.valueOf("votos",Var.VAR_NULL));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param idProjetoVotado
 * @param checado
 *
 * @author Wesley Miranda De Oliveira
 * @since 18/08/2023, 09:37:11
 *
 */
public static Var ObtemVoto(@ParamMetaData(description = "idProjetoVotado", id = "2a202a21") Var idProjetoVotado, @ParamMetaData(description = "checado", id = "68bd3e97") Var checado) throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
    Var.valueOf("vars.listaVotos"),
    Var.valueOf("aaa"));
    lista =
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.listaVotos"));
    System.out.println(lista.getObjectAsString());
    System.out.println(
    cronapi.screen.Operations.getValueOfField(
    Var.valueOf("vars.listaVotos")).getObjectAsString());
    if (
    Var.valueOf(
    cronapi.logic.Operations.isNullOrEmpty(lista).getObjectAsBoolean() && checado.getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.list.Operations.setFirst(lista,idProjetoVotado);
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
        Var.valueOf("vars.listaVotos"), lista);
        System.out.println(
        Var.valueOf("1").getObjectAsString());
    } else if (
    Var.valueOf(checado.getObjectAsBoolean() &&
    Var.valueOf(
    cronapi.list.Operations.size(lista).compareTo(
    Var.valueOf(2)) < 0).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.list.Operations.setLast(lista,idProjetoVotado);
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
        Var.valueOf("vars.listaVotos"), lista);
        System.out.println(
        Var.valueOf("2").getObjectAsString());
    } else if (checado
    .negate().getObjectAsBoolean()) {
        cronapi.list.Operations.remove(lista,
        cronapi.list.Operations.findFirst(lista, idProjetoVotado));
        System.out.println(
        Var.valueOf("3").getObjectAsString());
    } else {
        System.out.println(
        Var.valueOf("Senão").getObjectAsString());
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

