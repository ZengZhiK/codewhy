/*
 * CoreUtil工具类
 */
var CoreUtil = (function () {
  var coreUtil = {};

  coreUtil.sendAjax = function (url, params, ft, method) {
    var roleSaveLoading = top.layer.msg('数据提交中', {icon: 16, time: false, shade: 0.8});

    $.ajax({
      url: url,
      type: method,
      data: params,
      contentType: 'application/json',
      dataType: 'json',
      success: function (res) {
        top.layer.close(roleSaveLoading);
        if (res.code === 200) {
          if (ft !== undefined && typeof ft === "function") {
            ft(res);
          } else {
            layer.msg(res.msg);
          }
        } else {
          layer.msg(res.msg);
        }
      },
      error: function (jqXHR, textStatus, errorThrown) {
        top.layer.close(roleSaveLoading);
        layer.msg("服务器好像除了点问题");
      }
    });

  }

  return coreUtil;
})(CoreUtil, window);