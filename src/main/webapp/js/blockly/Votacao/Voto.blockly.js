window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Votacao = window.blockly.js.blockly.Votacao || {};
window.blockly.js.blockly.Votacao.Voto = window.blockly.js.blockly.Votacao.Voto || {};

/**
 * @function IniciarVotacao
 *
 *
 *
 * @param checkAceitarRegras
 *
 * @author José Zay
 * @since 17/08/2023, 14:50:55
 *
 */
window.blockly.js.blockly.Votacao.Voto.IniciarVotacaoArgs = [{ description: 'checkAceitarRegras', id: 'b8644fae' }];
window.blockly.js.blockly.Votacao.Voto.IniciarVotacao = async function(checkAceitarRegras) {
 var idIdeiaVotada, checado;
  //
  checkAceitarRegras = this.cronapi.conversion.toBoolean(checkAceitarRegras);
  //
  if (checkAceitarRegras) {
    //
    this.cronapi.screen.toggleClass("div-tela-regras-id", 'hidden');
    //
    this.cronapi.screen.toggleClass("div-tela-espera-voto-id", 'hidden');
  } else {
    //
    this.cronapi.screen.notify('error','É necessário aceitar as Regras');
  }
}

/**
 * @function ObtemVoto
 *
 *
 *
 * @param idIdeiaVotada
 * @param checado
 *
 * @author José Zay
 * @since 17/08/2023, 14:50:55
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, checado) {
 var lista;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  if (this.cronapi.conversion.toBoolean(checado)) {
    //
    if (this.cronapi.logic.isNullOrEmpty(lista)) {
      //
      lista = [];
    }
    //
    lista.push(idIdeiaVotada);
    //
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    //
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
      this.cronapi.screen.notify('success','Selecione no máximo 2 caixas de seleção');
    }
  } else {
    //
    lista.splice(((lista.indexOf(idIdeiaVotada) + 1) - 1), 1);
    //
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    //
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
 *
 *
 * @param checkUnicoVoto
 *
 * @author José Zay
 * @since 17/08/2023, 14:50:55
 *
 */
window.blockly.js.blockly.Votacao.Voto.FinalizarVotacaoArgs = [{ description: 'checkUnicoVoto', id: '8e5f7fd0' }];
window.blockly.js.blockly.Votacao.Voto.FinalizarVotacao = async function(checkUnicoVoto) {
 var idIdeiaVotada, checado;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  if (lista.length == 0) {
    //
    this.cronapi.screen.notify('error','É necessário votar em ao menos um projeto!');
  } else if (lista.length == 1 && !this.cronapi.conversion.toBoolean(checkUnicoVoto)) {
    //
    this.cronapi.screen.notify('error','É necessário confirmar que deseja votar em apenas um projeto!');
  } else {
  }
}
