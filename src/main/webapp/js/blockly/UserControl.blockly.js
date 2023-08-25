window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.UserControl = window.blockly.js.blockly.UserControl || {};

/**
 * @function resetPassword
 *
 * Descreva esta função...
 *
 * @param email
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.resetPasswordArgs = [{ description: 'email', id: '7afdf898' }];
window.blockly.js.blockly.UserControl.resetPassword = async function(email) {

  //
  if (this.cronapi.logic.isNullOrEmpty(email)) {
    //
    this.cronapi.screen.notify('info','O campo e-mail é obrigatório');
  } else {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Emails.ResetarSenha:ResetarSenha', async function(sender_res) {
        res = sender_res;
      //
      if (this.cronapi.json.getProperty(res, 'sucesso')) {
        //
        this.cronapi.screen.hideModal("forgotPasswordModal");
        //
        this.cronapi.screen.changeValueOfField("forgotPasswordEmail.value", '');
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(res, 'mensagem'));
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(res, 'mensagem'));
      }
    }.bind(this), email);
  }
}

/**
 * @function signUpValidation
 *
 * Descreva esta função...
 *
 * @param name
 * @param cpf
 * @param email
 * @param password
 * @param confirmPassword
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.signUpValidationArgs = [{ description: 'name2', id: '73abfb6a' }, { description: 'cpf', id: 'c2d32391' }, { description: 'email', id: '9ef5ba82' }, { description: 'password', id: '22aabdb1' }, { description: 'confirmPassword', id: '7318fb73' }];
window.blockly.js.blockly.UserControl.signUpValidation = async function(name2, cpf, email, password, confirmPassword) {

  //
  if (this.cronapi.logic.isNullOrEmpty(email)) {
    //
    this.cronapi.notification.customNotify('error', 'Campo e-mail é obrigatório', 'fade', 'top', 'center', 'true');
  } else if (this.cronapi.logic.isNullOrEmpty(name2)) {
    //
    this.cronapi.notification.customNotify('error', 'Campo nome é obrigatório', 'fade', 'top', 'center', 'true');
  } else if (name2.indexOf('.') + 1 != 0) {
    //
    this.cronapi.notification.customNotify('error', 'Nome não pode conter abreviações', 'fade', 'top', 'center', 'true');
  } else if (password != confirmPassword) {
    //
    this.cronapi.notification.customNotify('error', 'Senha e confirme a senha são obrigatórios e devem ser iguais', 'fade', 'top', 'center', 'true');
  } else {
    //
    if (password.indexOf('$') + 1 != 0 || password.indexOf(')') + 1 != 0 || password.indexOf('(') + 1 != 0 || password.indexOf('#') + 1 != 0 || password.indexOf('*') + 1 != 0 || password.indexOf('&') + 1 != 0 || password.indexOf('%') + 1 != 0) {
      //
      this.cronapi.notification.customNotify('error', 'Caracteres inválidos detectados #,%,),*,&,$,(', 'fade', 'top', 'center', 'true');
    } else {
      //
      this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.Usuario:cadastrarUsuario', async function(sender_res) {
          res = sender_res;
        //
        if (this.cronapi.json.getProperty(res, 'sucesso')) {
          //
          this.cronapi.notification.customNotify('success', this.cronapi.json.getProperty(res, 'mensagem'), 'fade', 'top', 'center', 'true');
          //
          this.cronapi.screen.changeValueOfField("vars.cadastroSucesso", true);
        } else {
          //
          this.cronapi.notification.customNotify('error', this.cronapi.json.getProperty(res, 'mensagem'), 'fade', 'top', 'center', 'true');
          //
          this.cronapi.screen.changeValueOfField("vars.cadastroSucesso", false);
        }
      }.bind(this), name2, cpf, email, password);
    }
  }
}

/**
 * @function signUp
 *
 * Signup
 *
 * @param signupUsername
 * @param signupEmail
 * @param signupPassword
 * @param signupConfirmPassword
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.signUpArgs = [{ description: 'signupUsername', id: 'ec5dbe32' }, { description: 'signupEmail', id: '62cce53e' }, { description: 'signupPassword', id: 'd42229ad' }, { description: 'signupConfirmPassword', id: 'a49023f3' }];
window.blockly.js.blockly.UserControl.signUp = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {

  //
  (await this.cronapi.authentication.signup(signupUsername, signupEmail, signupPassword, signupConfirmPassword));
}

/**
 * @function SalvarSenha
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.SalvarSenhaArgs = [];
window.blockly.js.blockly.UserControl.SalvarSenha = async function() {
 var nome;
  //
  reset = this.cronapi.screen.getParam('reset');
  //
  if (this.cronapi.screen.getValueOfField("vars.senha") != this.cronapi.screen.getValueOfField("vars.confirmaSenha")) {
    //
    this.cronapi.screen.notify('error','Os campos de nova senha e confirma nova senha não correspondem');
  } else {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Emails.ResetarSenha:SalvarResetSenha', async function(sender_retorno) {
        retorno = sender_retorno;
      //
      if (this.cronapi.json.getProperty(retorno, 'sucesso')) {
        //
        this.cronapi.screen.notify('success',this.cronapi.json.getProperty(retorno, 'mensagem'));
        //
        (await this.cronapi.util.sleep(3000));
        //
        this.cronapi.screen.changeView("#/home/login",[  ]);
      } else {
        //
        this.cronapi.screen.notify('error',this.cronapi.json.getProperty(retorno, 'mensagem'));
      }
    }.bind(this), reset, this.cronapi.screen.getValueOfField("vars.senha"), this.cronapi.screen.getValueOfField("vars.confirmaSenha"));
  }
}

/**
 * @function VerificaResetSenha
 *
 * Descreva esta função...
 *
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.VerificaResetSenhaArgs = [];
window.blockly.js.blockly.UserControl.VerificaResetSenha = async function() {
 var nome;
  //
  reset = this.cronapi.screen.getParam('reset');
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Emails.ResetarSenha:VerificarSolicitacaoResetSenha', async function(sender_retorno) {
      retorno = sender_retorno;
    //
    if (retorno) {
      //
      this.cronapi.screen.changeValueOfField("vars.validado", true);
    } else {
      //
      this.cronapi.notification.confirmDialogAlert('error', 'Falha ao resetar senha', 'Link inválido ou expirado para resetar senha', this.cronapi.notification.buttonConfirmDialogAlert('true', 'Fechar', async function() {
         //
        this.cronapi.screen.changeView("#/home/login",[  ]);
       }.bind(this)));
    }
  }.bind(this), reset);
}

/**
 * @function isValidSignup
 *
 * Descreva esta função...
 *
 * @param signupUsername
 * @param signupEmail
 * @param signupPassword
 * @param signupConfirmPassword
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.isValidSignupArgs = [{ description: 'signupUsername', id: 'abf7b641' }, { description: 'signupEmail', id: '38708282' }, { description: 'signupPassword', id: 'daf1486e' }, { description: 'signupConfirmPassword', id: '3f9f5d23' }];
window.blockly.js.blockly.UserControl.isValidSignup = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {

  return this.cronapi.authentication.isValidSignup(signupUsername, signupEmail, signupPassword, signupConfirmPassword);
}

/**
 * @function verificaAbreviacao
 *
 * Descreva esta função...
 *
 * @param nome
 *
 * @author Matheus Portugal Ribeiro
 * @since 15/02/2023, 11:44:31
 *
 */
window.blockly.js.blockly.UserControl.verificaAbreviacaoArgs = [{ description: 'nome', id: '8fd49ed5' }];
window.blockly.js.blockly.UserControl.verificaAbreviacao = async function(nome) {

  //
  if (!this.cronapi.logic.isNullOrEmpty(nome)) {
    //
    if (nome.indexOf('.') + 1 != 0) {
      //
      this.cronapi.notification.customNotify('error', 'Nome não pode conter abreviações', 'fade', 'top', 'center', 'true');
    }
  }
}
