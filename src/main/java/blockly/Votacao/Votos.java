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
 * @author Wesley Miranda De Oliveira
 * @since 22/08/2023, 08:50:09
 *
 */
public static Var BackResultadoRank() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var resultadoVotacao = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.TratamentoData.TratamentoData:ResultadoData"));
    resultadoVotacao =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	v.voto, \n	COUNT(v.voto) as numeroVotos\nfrom \n	Votos v   \ngroup by \n	v.voto\norder by numeroVotos desc"));
    return
cronapi.json.Operations.toJson(resultadoVotacao);
   }
 }.call();
}

/**
 *
 * @author Wesley Miranda De Oliveira
 * @since 22/08/2023, 08:50:09
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
 * @author Wesley Miranda De Oliveira
 * @since 22/08/2023, 08:50:09
 *
 */
public static Var BackVotosComputados() throws Exception {
 return new Callable<Var>() {

   private Var votosComputados = Var.VAR_NULL;

   public Var call() throws Exception {
    votosComputados =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	COUNT(v) \nfrom \n	Votos v"));
    return
cronapi.list.Operations.getFirst(votosComputados);
   }
 }.call();
}

/**
 *
 * @param listaIdItemVoto
 *
 * @author Wesley Miranda De Oliveira
 * @since 22/08/2023, 08:50:09
 *
 */
public static Var BackVotosUsuario() throws Exception {
 return new Callable<Var>() {

   private Var votosComputados = Var.VAR_NULL;

   public Var call() throws Exception {
    votosComputados =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Votos"),Var.valueOf("select \n	COUNT(v) \nfrom \n	Votos v  \nwhere \n	v.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.util.Operations.getCurrentUserName()));
    return
cronapi.list.Operations.getFirst(votosComputados);
   }
 }.call();
}

}

