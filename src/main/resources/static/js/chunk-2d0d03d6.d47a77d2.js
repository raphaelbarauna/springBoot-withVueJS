(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d03d6"],{"66aa":function(r,e,t){"use strict";t.r(e);var n=function(){var r=this,e=r.$createElement,t=r._self._c||e;return t("div",{staticClass:"container"},[t("header",{staticClass:"jumbotron"},[t("h3",[t("strong",[r._v(r._s(r.currentUser.userName))]),r._v(" Profile ")])]),t("p",[t("strong",[r._v("Token:")]),r._v(" "+r._s(r.currentUser.token.substring(0,20))+" ... "+r._s(r.currentUser.token.substr(r.currentUser.token.length-20))+" ")]),t("p",[t("strong",[r._v("Id:")]),r._v(" "+r._s(r.currentUser.id)+" ")]),t("p",[t("strong",[r._v("Email:")]),r._v(" "+r._s(r.currentUser.email)+" ")]),t("strong",[r._v("Authorities:")]),t("ul",r._l(r.currentUser.roles,(function(e,n){return t("li",{key:n},[r._v(r._s(e))])})),0)])},s=[],u={name:"Profile",computed:{currentUser:function(){return this.$store.state.auth.user}},mounted:function(){this.currentUser||this.$router.push("/login")}},o=u,i=t("2877"),c=Object(i["a"])(o,n,s,!1,null,null,null);e["default"]=c.exports}}]);
//# sourceMappingURL=chunk-2d0d03d6.d47a77d2.js.map