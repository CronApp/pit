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
 * @since 13/11/2023, 09:06:22
 *
 */
public static Var BackFinalizarVoto(@ParamMetaData(description = "listaIdItemVoto", id = "fb0d967d") Var listaIdItemVoto) throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    user =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id, \n	u.votou \nfrom \n	User u  \nwhere \n	u.normalizedEmail = :normalizedEmail"),Var.valueOf("normalizedEmail",
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
    if (
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.TratamentoData.TratamentoData:ResultadoData")).getObjectAsBoolean()) {
        return Var.valueOf(
        Var.VAR_FALSE);
    }
    cronapi.database.Operations.beginTransaction(Var.VAR_NULL);
    for (Iterator it_j = listaIdItemVoto.iterator(); it_j.hasNext();) {
        j = Var.valueOf(it_j.next());
        System.out.println(user.getObjectAsString());
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
 * Se a data atual for maior do que a data de divulgação dos resultados, então manda os dados dos resultados pro front.
 *
 * @author José Zay
 * @since 13/11/2023, 09:06:22
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
    return
cronapi.json.Operations.toJson(resultadoVotacao);
   }
 }.call();
}

/**
 *
 * @author José Zay
 * @since 13/11/2023, 09:06:22
 *
 */
public static Var BackUsuarioVotou() throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var listaIdItemVoto = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.list.Operations.getFirst((
cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.votou \nfrom \n	User u  \nwhere \n	u.normalizedEmail = :normalizedEmail"),Var.valueOf("normalizedEmail",
cronapi.util.Operations.getCurrentUserName()))));
   }
 }.call();
}

/**
 *
 * @author José Zay
 * @since 13/11/2023, 09:06:22
 *
 */
public static Var BackVotosComputados() throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var listaIdItemVoto = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
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
 * @since 13/11/2023, 09:06:22
 *
 */
public static Var BackVotosUsuario() throws Exception {
 return new Callable<Var>() {

   private Var user = Var.VAR_NULL;
   private Var listaIdItemVoto = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var resultadoVotacao = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	v.id, \n	v.voto \nfrom \n	Votos v  \nwhere \n	v.user.normalizedEmail = :userNormalizedEmail"),Var.valueOf("userNormalizedEmail",
cronapi.util.Operations.getCurrentUserName()));
   }
 }.call();
}

}

