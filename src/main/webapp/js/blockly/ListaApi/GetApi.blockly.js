window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ListaApi = window.blockly.js.blockly.ListaApi || {};
window.blockly.js.blockly.ListaApi.GetApi = window.blockly.js.blockly.ListaApi.GetApi || {};

/**
 * @function GetApi
 *
 *
 *
 *
 * @author José Zay
 * @since 23/08/2023, 09:52:15
 *
 */
window.blockly.js.blockly.ListaApi.GetApi.GetApiArgs = [];
window.blockly.js.blockly.ListaApi.GetApi.GetApi = async function() {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Airtable.Airtable:GetApi', async function(sender_item) {
      item = sender_item;
    //
    this.cronapi.screen.changeValueOfField("vars.listaIdeias", this.cronapi.json.getProperty(item, 'records'));
  }.bind(this));
}
