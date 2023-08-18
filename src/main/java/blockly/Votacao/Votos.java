package blockly.Votacao;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Votos {

public static final int TIMEOUT = 300;

/**
 *
 * @param listaIdItemVoto
 *
 * @author Wesley Miranda De Oliveira
 * @since 18/08/2023, 11:37:40
 *
 */
public static Var FinalizarVoto(@ParamMetaData(description = "listaIdItemVoto", id = "fb0d967d") Var listaIdItemVoto) throws Exception {
 return new Callable<Var>() {

   private Var userId = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    userId =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    System.out.println(listaIdItemVoto.getObjectAsString());
    if (
    Var.valueOf(
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.votou \nfrom \n	User u  \nwhere \n	u.id = :id"),Var.valueOf("id",
    cronapi.util.Operations.getCurrentUserName()))
    .negate().getObjectAsBoolean() &&
    cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	v.voto \nfrom \n	Votos v  \nwhere \n	v.user.id = :userId"),Var.valueOf("userId",userId)).getObjectAsBoolean()).getObjectAsBoolean()) {
        for (Iterator it_j = listaIdItemVoto.iterator(); it_j.hasNext();) {
            j = Var.valueOf(it_j.next());
            System.out.println(j.getObjectAsString());
            item =
            cronapi.database.Operations.insert(Var.valueOf("app.entity.Votos"),Var.valueOf("user",userId),Var.valueOf("voto",
            cronapi.conversion.Operations.convert(j,
            Var.valueOf("STRING"))));
        } // end for
        cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	votou = :votou \nwhere \n	id = :id"),Var.valueOf("votou",
        Var.VAR_TRUE),Var.valueOf("id",userId));
    } else {
      {}
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
 * @since 18/08/2023, 11:37:40
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

