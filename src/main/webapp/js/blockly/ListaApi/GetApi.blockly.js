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
 * @author Wesley Miranda De Oliveira
 * @since 10/08/2023, 08:20:04
 *
 */
window.blockly.js.blockly.ListaApi.GetApi.GetApiArgs = [];
window.blockly.js.blockly.ListaApi.GetApi.GetApi = async function() {
 var item;
  //
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Airtable.Airtable:GetApi', async function(sender_item) {
      item = sender_item;
    //
    console.log(item);
  }.bind(this));
}
