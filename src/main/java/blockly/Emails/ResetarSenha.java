package blockly.Emails;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", put = "Public")
public class ResetarSenha {

public static final int TIMEOUT = 300;

/**
 *
 * Email
 *
 * @param email
 *
 * @author Silvio De Oliveira Carlos
 * @since 25/08/2023, 08:49:16
 *
 */
public static Var ResetarSenha(@ParamMetaData(description = "email", id = "c3852ac6") Var email) throws Exception {
 return new Callable<Var>() {

   private Var ret = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;
   private Var idReset = Var.VAR_NULL;
   private Var nomeUsuario = Var.VAR_NULL;
   private Var inserirReset = Var.VAR_NULL;
   private Var urlReset = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         if (
        cronapi.validation.Operations.validateEmail(email)
        .negate().getObjectAsBoolean()) {
            ret =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("O e-mail informado é inválido")));
        } else {
            usuario =
            cronapi.list.Operations.getFirst((
            cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u \nwhere \n	u.email = :email"),Var.valueOf("email",email))));
            if (
            cronapi.logic.Operations.isNullOrEmpty(usuario).getObjectAsBoolean()) {
                ret =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_FALSE) , Var.valueOf("mensagem",
                Var.valueOf("O e-mail informado não está cadastrado")));
            } else {
                idReset =
                cronapi.util.Operations.generateUUID();
                nomeUsuario =
                cronapi.list.Operations.getFirst((
                cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.name \nfrom \n	User u \nwhere \n	u.email = :email"),Var.valueOf("email",email))));
                cronapi.database.Operations.beginTransaction(Var.valueOf("app"));
                cronapi.database.Operations.execute(Var.valueOf("app.entity.ResetSenha"), Var.valueOf("delete from \n	\n	ResetSenha  \nwhere \n	user.id = :id"),Var.valueOf("id",usuario));
                cronapi.database.Operations.commitTransaction(Var.valueOf("app"));
                inserirReset =
                cronapi.database.Operations.insert(Var.valueOf("app.entity.ResetSenha"),Var.valueOf("id",idReset),Var.valueOf("dataLimite",
                cronapi.dateTime.Operations.incHour(
                cronapi.dateTime.Operations.getNow(),
                Var.valueOf(1))),Var.valueOf("user",usuario));
                urlReset =
                Var.valueOf(
                cronapi.util.Operations.getBaseUrl().getObjectAsString() +
                Var.valueOf("/#/reset-senha?reset=").getObjectAsString() +
                idReset.getObjectAsString());
                System.out.println(
                Var.valueOf("url criada").getObjectAsString());
                System.out.println(urlReset.getObjectAsString());
                item =
                cronapi.util.Operations.callBlockly(Var.valueOf("blockly.Emails.Email:EnviarEmailComBotao"), Var.valueOf("9aa6d127", email), Var.valueOf("6ac3bc79", nomeUsuario), Var.valueOf("b4be60df",
                Var.valueOf("Foi solicitado um reset de senha no sistema <b>Projeto Inova Techne (PIT)</b>. Caso você não tenha solicitado tal ação essa mensagem pode ser ignorada.")), Var.valueOf("58c17ec5",
                Var.valueOf("Reset de senha")), Var.valueOf("37f93f43",
                Var.valueOf("PIT | Reset de senha")), Var.valueOf("1ba68f9f", urlReset), Var.valueOf("615e5d16",
                Var.valueOf("Clique aqui para resetar sua senha")));
                ret =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_TRUE) , Var.valueOf("mensagem",
                Var.valueOf("Foi enviado instruções para resetar a senha pra seu e-mail.")));
            }
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         cronapi.util.Operations.throwException(err);
     }
    return ret;
   }
 }.call();
}

/**
 *
 * @param reset
 * @param senha
 * @param confirmaSenha
 *
 * @author Silvio De Oliveira Carlos
 * @since 25/08/2023, 08:49:16
 *
 */
public static Var SalvarResetSenha(@ParamMetaData(description = "reset", id = "c10b6d4f") Var reset, @ParamMetaData(description = "param_senha", id = "131247f2") Var param_senha, @ParamMetaData(description = "confirmaSenha", id = "81ae3a2e") Var confirmaSenha) throws Exception {
 return new Callable<Var>() {

   // param
   private Var senha = param_senha;
   // end
   private Var usuario = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         usuario =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.ResetSenha"),Var.valueOf("select \n	r.user.id \nfrom \n	ResetSenha r \nwhere \n	r.id = :id"),Var.valueOf("id",reset))));
        if (
        cronapi.logic.Operations.isNullOrEmpty(usuario).getObjectAsBoolean()) {
            retorno =
            cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
            Var.VAR_FALSE) , Var.valueOf("mensagem",
            Var.valueOf("Falha ao resetar senha, se o erro persistir conte um administrador")));
        } else {
            if (
            Var.valueOf(!senha.equals(confirmaSenha)).getObjectAsBoolean()) {
                retorno =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_FALSE) , Var.valueOf("mensagem",
                Var.valueOf("Os campos de nova senha e confirma nova senha não correspondem")));
            } else {
                cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	password = :password \nwhere \n	id = :usuarioId"),Var.valueOf("password",senha),Var.valueOf("usuarioId",usuario));
                retorno =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_TRUE) , Var.valueOf("mensagem",
                Var.valueOf("Senha alterada com sucesso")));
            }
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         retorno =
        cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
        Var.VAR_FALSE) , Var.valueOf("mensagem",
        Var.valueOf("Falha ao resetar senha, se o erro persistir conte um administrador")));
        cronapi.util.Operations.audit(
        Var.valueOf("Erro ao Emails.ResetarSenha.SalvarResetSenha"),
        Var.valueOf(""),
        Var.valueOf("Trace"), err);
     }
    return retorno;
   }
 }.call();
}

/**
 *
 * @param reset
 *
 * @author Silvio De Oliveira Carlos
 * @since 25/08/2023, 08:49:16
 *
 */
public static Var VerificarSolicitacaoResetSenha(@ParamMetaData(description = "reset", id = "c10b6d4f") Var reset) throws Exception {
 return new Callable<Var>() {

   private Var err = Var.VAR_NULL;
   private Var dataBanco = Var.VAR_NULL;
   private Var eValido = Var.VAR_NULL;

   public Var call() throws Exception {
    try {
         dataBanco =
        cronapi.list.Operations.getFirst((
        cronapi.database.Operations.query(Var.valueOf("app.entity.ResetSenha"),Var.valueOf("select \n	r.dataLimite \nfrom \n	ResetSenha r \nwhere \n	r.id = :id"),Var.valueOf("id",reset))));
        if (
        cronapi.logic.Operations.isNullOrEmpty(dataBanco).getObjectAsBoolean()) {
            eValido =
            Var.VAR_FALSE;
        } else {
            if (
            Var.valueOf(
            cronapi.dateTime.Operations.getSecondsBetweenDates(
            cronapi.conversion.Operations.stringToDate(dataBanco,
            Var.valueOf("")),
            cronapi.dateTime.Operations.getNow()).compareTo(
            Var.valueOf(0)) > 0).getObjectAsBoolean()) {
                eValido =
                Var.VAR_TRUE;
            } else {
                eValido =
                Var.VAR_FALSE;
            }
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         eValido =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(err);
     }
    return eValido;
   }
 }.call();
}

}

