/**
  项目JS主入口
  以依赖layui的layer和form模块为例
  layui.define([mods], callback)
  [mods]是可选参数，用于声明自定义模块的依赖模块。callback是模块加载完毕的回调函数
*/

layui.define(['layer', 'form'], function(exports){
  var layer = layui.layer
  ,form = layui.form;
  
  layer.msg('Hello World');
  
  /**
   * 定义了一个叫index的模块，layui.define（）会返回一个模块的接口，
   * 即上述代码中的exports,这个接口即模块的功能，exports实质上是一个函数，
   * 它拥有两个参数，第一个是模块名，第二个是接口本身实现的功能，当你声明了上述demo模块后，
   * demo模块就被注册到了layui下，即可通过layui.index（）来执行模块的接口
   * (即执行alert（‘hello world！’）)。
   */
  exports('index', function(){
	  alert('Hello World!');
  }); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});