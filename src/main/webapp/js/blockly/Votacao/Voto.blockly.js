window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Votacao = window.blockly.js.blockly.Votacao || {};
window.blockly.js.blockly.Votacao.Voto = window.blockly.js.blockly.Votacao.Voto || {};

/**
 * @function IniciarVotacao
 *
 * Oculta tela de aceite de regras, e exibe tela de votações efetuadas (vazia).
 *
 * @param checkAceitarRegras
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.IniciarVotacaoArgs = [{ description: 'checkAceitarRegras', id: 'b8644fae' }];
window.blockly.js.blockly.Votacao.Voto.IniciarVotacao = async function(checkAceitarRegras) {
 var x;
  //
  if (this.cronapi.conversion.toBoolean(checkAceitarRegras)) {
    //
    this.cronapi.screen.addClass("div-tela-regras-id", 'hidden');
    //
    this.cronapi.screen.removeClass("div-tela-espera-voto-id", 'hidden');
  } else {
    //
    this.cronapi.notification.customNotify('error', 'É necessário aceitar as Regras!', 'fade', 'bottom', 'right', 'true');
  }
}

/**
 * @function ObtemVoto
 *
 * Trata a votação em si, verificando os votos selecionados no
 * acordeão e alterando a tela de votos efetuados de acordo.
 *
 * @param idIdeiaVotada
 * @param checado
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, checado) {

  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  if (this.cronapi.conversion.toBoolean(checado)) {
    //
    if (this.cronapi.logic.isNullOrEmpty(lista)) {
      // Inicializa pela primeira vez a variável lista.
      lista = [];
    }
    //
    lista.push(idIdeiaVotada);
    // Atualiza variável de tela.
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    // Controla visualizações da tela de votações efetuadas
    // (da direita) conforme número de votos selecionados.
    // -Com nenhum voto, deve aparecer uma tela 'vazia' esperando algo.
    // -Com um voto, deve aparecer o voto selecionado e uma checkbox
    // de confirmação se o votante irá apenas efetuar um voto.
    // -Com dois votos deve aparecer apenas os votos e os botões para finalizar.
    if (lista.length <= 1) {
      //
      this.cronapi.screen.addClass("div-tela-espera-voto-id", 'hidden');
      //
      this.cronapi.screen.removeClass("div-tela-votados-id", 'hidden');
      //
      this.cronapi.screen.removeClass("div-unico-voto", 'hidden');
    } else if (lista.length == 2) {
      //
      this.cronapi.screen.addClass("div-unico-voto", 'hidden');
    } else {
      //
      this.cronapi.notification.customNotify('error', 'Selecione no máximo 2 caixas de seleção', 'fade', 'bottom', 'right', 'true');
    }
  } else {
    //
    lista.splice(((lista.indexOf(idIdeiaVotada) + 1) - 1), 1);
    // Atualiza variável de tela.
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    // Controla visualizações da tela de votações efetuadas
    // (da direita) conforme número de votos selecionados.
    // -Com nenhum voto, deve aparecer uma tela 'vazia' esperando algo.
    // -Com um voto, deve aparecer o voto selecionado e uma checkbox
    // de confirmação se o votante irá apenas efetuar um voto.
    // -Com dois votos deve aparecer apenas os votos e os botões para finalizar.
    if (lista.length <= 0) {
      //
      this.cronapi.screen.removeClass("div-tela-espera-voto-id", 'hidden');
      //
      this.cronapi.screen.addClass("div-tela-votados-id", 'hidden');
      //
      this.cronapi.screen.addClass("div-unico-voto", 'hidden');
    } else if (lista.length == 1) {
      //
      this.cronapi.screen.removeClass("div-unico-voto", 'hidden');
    }
  }
}

/**
 * @function FinalizarVotacao
 *
 * Valida se os votos informados são válidos em quantidade
 * e então repassa os dados para serem gravados.
 *
 * @param checkUnicoVoto
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.FinalizarVotacaoArgs = [{ description: 'checkUnicoVoto', id: '8e5f7fd0' }];
window.blockly.js.blockly.Votacao.Voto.FinalizarVotacao = async function(checkUnicoVoto) {
 var x;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  if (lista.length == 0) {
    //
    this.cronapi.notification.customNotify('error', 'É necessário votar em ao menos um Projeto!', 'fade', 'bottom', 'right', 'true');
  } else if (lista.length == 1 && !this.cronapi.conversion.toBoolean(checkUnicoVoto)) {
    //
    this.cronapi.notification.customNotify('error', 'É necessário confirmar que deseja votar em apenas um Projeto!', 'fade', 'bottom', 'right', 'true');
  } else {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Votacao.Votos:BackFinalizarVoto', async function(sender_item) {
        item = sender_item;
      //
      if (item) {
        //
        (await this.cronapi.client('blockly.js.blockly.Votacao.Voto.VotosComputados').run());
        //
        (await this.cronapi.client('blockly.js.blockly.Votacao.Voto.VotosUsuario').run());
        //
        this.cronapi.screen.addClass("div-grupo-tela-votacao-id", 'hidden');
        //
        this.cronapi.screen.removeClass("div-grupo-tela-votos-usuario-id", 'hidden');
        //
        this.cronapi.notification.customNotify('success', 'Sucesso ao registrar Votos!', 'fade', 'bottom', 'right', 'true');
      } else {
        //
        this.cronapi.notification.customNotify('error', 'Erro ao registrar Votos!', 'fade', 'bottom', 'right', 'true');
      }
    }.bind(this), lista);
  }
}

/**
 * @function UsuarioVotou
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.UsuarioVotouArgs = [];
window.blockly.js.blockly.Votacao.Voto.UsuarioVotou = async function() {
 var x, ideia;
  return (await this.cronapi.server('blockly.Votacao.Votos.BackUsuarioVotou').toPromise().run());
}

/**
 * @function VotosComputados
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.VotosComputadosArgs = [];
window.blockly.js.blockly.Votacao.Voto.VotosComputados = async function() {
 var x, ideia;
  //
  this.cronapi.screen.changeValueOfField("vars.votosComputados", (await this.cronapi.server('blockly.Votacao.Votos.BackVotosComputados').toPromise().run()));
}

/**
 * @function VotosResultadoRank
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.VotosResultadoRankArgs = [];
window.blockly.js.blockly.Votacao.Voto.VotosResultadoRank = async function() {
 var x, ideia;
  //
  if (this.cronapi.dateTime.getNow() >= this.cronapi.dateTime.newDate(2023, 8, 25, 0, 0, 0)) {
    //
    this.cronapi.screen.changeValueOfField("vars.resultadoVotos", (await this.cronapi.server('blockly.Votacao.Votos.BackResultadoRank').toPromise().run()));
    //
    this.cronapi.screen.removeClass("div-resultado-rank-id", 'hidden');
  } else {
    //
    this.cronapi.screen.removeClass("id-resultado-info-data", 'hidden');
  }
}

/**
 * @function InicializarStatusVotacaoUser
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.InicializarStatusVotacaoUserArgs = [];
window.blockly.js.blockly.Votacao.Voto.InicializarStatusVotacaoUser = async function() {
 var x, ideia;
  //
  if ((await this.cronapi.server('blockly.Usuario.UsuarioComite.RetornaUsarioPertenceComite').toPromise().run())) {
    //
    this.cronapi.screen.removeClass("div-grupo-tela-resultado-voto-id", 'hidden');
    //
    (await this.cronapi.client('blockly.js.blockly.Votacao.Voto.VotosResultadoRank').run());
    //
    (await this.cronapi.client('blockly.js.blockly.Votacao.Voto.VotosComputados').run());
  } else {
    //
    if ((await this.cronapi.client('blockly.js.blockly.Votacao.Voto.UsuarioVotou').run())) {
      //
      (await this.cronapi.client('blockly.js.blockly.Votacao.Voto.VotosComputados').run());
      //
      (await this.cronapi.client('blockly.js.blockly.Votacao.Voto.VotosUsuario').run());
      //
      this.cronapi.screen.removeClass("div-grupo-tela-votos-usuario-id", 'hidden');
    } else {
      //
      this.cronapi.screen.removeClass("div-grupo-tela-votacao-id", 'hidden');
    }
  }
}

/**
 * @function VotosUsuario
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.VotosUsuarioArgs = [];
window.blockly.js.blockly.Votacao.Voto.VotosUsuario = async function() {
 var x, ideia;
  //
  this.cronapi.screen.changeValueOfField("vars.votosUsuario", (await this.cronapi.server('blockly.Votacao.Votos.BackVotosUsuario').toPromise().run()));
}

/**
 * @function RemoveVoto
 *
 *
 *
 * @param ideia
 *
 * @author José Zay
 * @since 29/08/2023, 11:19:32
 *
 */
window.blockly.js.blockly.Votacao.Voto.RemoveVotoArgs = [{ description: 'ideia', id: '6b26f1a1' }];
window.blockly.js.blockly.Votacao.Voto.RemoveVoto = async function(ideia) {
 var x;
  //
  console.log(ideia);
}
