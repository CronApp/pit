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
 * @author José Zay
 * @since 23/08/2023, 10:16:58
 *
 */
public static Var BackFinalizarVoto(@ParamMetaData(description = "listaIdItemVoto", id = "fb0d967d") Var listaIdItemVoto) throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    user =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id, \n	u.votou \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    if (
    cronapi.database.Operations.getField(user, Var.valueOf("this[1]")).getObjectAsBoolean()) {
        return Var.valueOf(
        Var.VAR_FALSE);
    }
    if (cronapi.list.Operations.isEmpty(listaIdItemVoto).getObjectAsBoolean()) {
        return Var.valueOf(
        Var.VAR_FALSE);
    }
    cronapi.database.Operations.beginTransaction(Var.VAR_NULL);
    for (Iterator it_j = listaIdItemVoto.iterator(); it_j.hasNext();) {
        j = Var.valueOf(it_j.next());
        item =
        cronapi.database.Operations.insert(Var.valueOf("app.entity.Votos"),Var.valueOf("user",
        cronapi.database.Operations.getField(user, Var.valueOf("this[0]"))),Var.valueOf("voto",
        cronapi.conversion.Operations.convert(j,
        Var.valueOf("STRING"))));
    } // end for
    cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	votou = :votou \nwhere \n	id = :id"),Var.valueOf("votou",
    Var.VAR_TRUE),Var.valueOf("id",
    cronapi.database.Operations.getField(user, Var.valueOf("this[0]"))));
    cronapi.database.Operations.commitTransaction(Var.VAR_NULL);
    return
Var.VAR_TRUE;
   }
 }.call();
}

/**
 *
 * @author José Zay
 * @since 23/08/2023, 10:16:58
 *
 */
public static Var BackResultadoRank() throws Exception {
 return new Callable<Var>() {

   private Var resultadoVotacao = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.TratamentoData.TratamentoData:ResultadoData")).getObjectAsBoolean()) {
        resultadoVotacao =
        cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	v.voto, \n	COUNT(v.voto) as numeroVotos\nfrom \n	Votos v   \ngroup by \n	v.voto\norder by numeroVotos desc"));
    }
    System.out.println(
    Var.valueOf("resultadoRank").getObjectAsString());
    return
cronapi.json.Operations.toJson(resultadoVotacao);
   }
 }.call();
}

/**
 *
 * @author José Zay
 * @since 23/08/2023, 10:16:58
 *
 */
public static Var BackUsuarioVotou() throws Exception {
 return new Callable<Var>() {

   private Var votou = Var.VAR_NULL;

   public Var call() throws Exception {
    votou =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.votou \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    System.out.println(
    cronapi.list.Operations.getFirst(votou).getObjectAsString());
    return
cronapi.list.Operations.getFirst(votou);
   }
 }.call();
}

/**
 *
 * @author José Zay
 * @since 23/08/2023, 10:16:58
 *
 */
public static Var BackVotosComputados() throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var listaIdItemVoto = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var votou = Var.VAR_NULL;
   private Var resultadoVotacao = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	COUNT(v) \nfrom \n	Votos v"))));
   }
 }.call();
}

/**
 *
 * @author José Zay
 * @since 23/08/2023, 10:16:58
 *
 */
public static Var BackVotosUsuario() throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var listaIdItemVoto = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var votou = Var.VAR_NULL;
   private Var resultadoVotacao = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	v.id, \n	v.voto \nfrom \n	Votos v  \nwhere \n	v.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
cronapi.util.Operations.getCurrentUserName()));
   }
 }.call();
}

}

