package blockly.Usuario;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;
import org.springframework.web.bind.annotation.*;


@RestController
@CronapiMetaData(type = "blockly")
@CronappSecurity
public class EditarPerfil {

public static final int TIMEOUT = 300;

/**
 *
 * @param nome
 *
 * @author José Zay
 * @since 28/08/2023, 15:38:07
 *
 */
@RequestMapping(path = "/api/cronapi/rest/Usuario.EditarPerfil:SalvarAlteracoes", method = RequestMethod.GET, consumes = "*/*")
public static Var SalvarAlteracoes(@ParamMetaData(description = "param_nome", id = "aa4ae81c") Var param_nome) throws Exception {
 return new Callable<Var>() {

   // param
   private Var nome = param_nome;
   // end

   public Var call() throws Exception {
    if (
    cronapi.logic.Operations.isNullOrEmpty(nome).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Digite seu nome."));
    } else if (
    Var.valueOf(
    Var.valueOf(nome.length()).compareTo(
    Var.valueOf(3)) <= 0).getObjectAsBoolean()) {
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("error"),
        Var.valueOf("Seu nome deve ter mais de 3 caracteres."));
    } else {
        cronapi.database.Operations.execute(Var.valueOf("app.entity.User"), Var.valueOf("update \n	User  \nset \n	name = :name \nwhere \n	userName = :userName"),Var.valueOf("name",nome),Var.valueOf("userName",
        cronapi.util.Operations.getCurrentUserName()));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideModal"),
        Var.valueOf("modalEdicaoPerfil"));
        cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
        Var.valueOf("Nome alterado com sucesso!"));
    }
    return Var.VAR_NULL;
   }
 }.call();
}

}

