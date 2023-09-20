package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", put = "Public")
public class ResetSenha {

public static final int TIMEOUT = 300;

/**
 *
 * @param reset
 * @param senha
 * @param confirmarSenha
 *
 * @author José Zay
 * @since 20/09/2023, 08:04:01
 *
 */
@RequestMapping(path = "/api/cronapi/rest/Emails.ResetSenha.ResetSenha:Resetar", method = RequestMethod.GET, consumes = "*/*")
public static Var Resetar(@ParamMetaData(description = "reset", id = "7b749659") Var reset, @ParamMetaData(description = "senha", id = "972945ce") Var senha, @ParamMetaData(description = "confirmarSenha", id = "864be41c") Var confirmarSenha) throws Exception {
 return new Callable<Var>() {

   private Var dataBanco = Var.VAR_NULL;
   private Var eValido = Var.VAR_NULL;
   private Var retorno = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;

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
                retorno =
                cronapi.map.Operations.createObjectMapWith(Var.valueOf("sucesso",
                Var.VAR_FALSE) , Var.valueOf("mensagem",
                Var.valueOf("Link Expirado")));
            }
        }
     } catch (Exception err_exception) {
          err = Var.valueOf(err_exception);
         eValido =
        Var.VAR_FALSE;
        cronapi.util.Operations.throwException(err);
     }
    if (eValido.getObjectAsBoolean()) {
        retorno =
        Var.valueOf(SalvarResetSenha(reset, senha, confirmarSenha));
    }
    System.out.println(retorno.getObjectAsString());
    return retorno;
   }
 }.call();
}

/**
 *
 * @param reset
 * @param senha
 * @param confirmaSenha
 *
 * @author José Zay
 * @since 20/09/2023, 08:04:01
 *
 */
public static Var SalvarResetSenha(@ParamMetaData(description = "reset", id = "c10b6d4f") Var reset, @ParamMetaData(description = "param_senha", id = "131247f2") Var param_senha, @ParamMetaData(description = "confirmaSenha", id = "81ae3a2e") Var confirmaSenha) throws Exception {
 return new Callable<Var>() {

   // param
   private Var senha = param_senha;
   // end
   private Var retorno = Var.VAR_NULL;
   private Var err = Var.VAR_NULL;
   private Var usuario = Var.VAR_NULL;

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

}

