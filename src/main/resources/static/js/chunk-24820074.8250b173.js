(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-24820074"],{"11b2":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"box"},[a("submit-video")],1)},o=[],i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-upload",{ref:"my",staticClass:"upload-demo",attrs:{drag:"","auto-upload":!1,"http-request":t.myupload,"before-upload":t.beforeAvatarUpload,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),a("div",{staticClass:"el-upload__text"},[t._v("将文件拖到此处，或"),a("em",[t._v("点击上传")])]),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("视频不能超过500M")])]),a("submit-img",{ref:"submitImg",staticClass:"img"}),a("el-input",{attrs:{type:"textarea",autosize:"",placeholder:"请输入视频名字"},model:{value:t.textarea1,callback:function(e){t.textarea1=e},expression:"textarea1"}}),a("div",{staticStyle:{margin:"20px 0"}}),a("el-input",{attrs:{type:"textarea",autosize:{minRows:2,maxRows:4},placeholder:"请输入视频描述"},model:{value:t.textarea2,callback:function(e){t.textarea2=e},expression:"textarea2"}}),a("div",{staticClass:"videoType"},[a("el-dropdown",{staticClass:"type",on:{command:t.handleCommand}},[a("el-button",{attrs:{type:"info"}},[t._v(" "+t._s(t.type)),a("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",{attrs:{command:"java"}},[t._v("java")]),a("el-dropdown-item",{attrs:{command:"web"}},[t._v("web")]),a("el-dropdown-item",{attrs:{command:"python"}},[t._v("python")]),a("el-dropdown-item",{attrs:{command:"C/C++"}},[t._v("C/C++")]),a("el-dropdown-item",{attrs:{command:"其他"}},[t._v("其他")])],1)],1)],1),a("div",{staticClass:"paywidth"},[a("el-dropdown",{staticClass:"type",on:{command:t.handleCommand2}},[a("el-button",{attrs:{type:"info"}},[t._v(" "+t._s(t.quanxain)),a("i",{staticClass:"el-icon-arrow-down el-icon--right"})]),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",{attrs:{command:"0"}},[t._v("免费")]),a("el-dropdown-item",{attrs:{command:"1"}},[t._v("VIP")]),a("el-dropdown-item",{attrs:{command:"2"}},[t._v("收费")])],1)],1)],1),t.showPay?a("input",{directives:[{name:"model",rawName:"v-model",value:t.pay,expression:"pay"}],staticClass:"inputPay",attrs:{type:"text",placeholder:"输入视频价格"},domProps:{value:t.pay},on:{input:[function(e){e.target.composing||(t.pay=e.target.value)},t.handleInput]}}):t._e(),a("el-button",{staticClass:"submit",attrs:{type:"primary"},on:{click:t.uploading}},[t._v("提交")]),a("el-button",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:t.isUpLoading,expression:"isUpLoading",modifiers:{fullscreen:!0,lock:!0}}],staticStyle:{position:"fixed",left:"-1000px"},attrs:{"element-loading-text":"上传中"},on:{click:t.openFullScreen1}})],1)},n=[],r=(a("ac1f"),a("5319"),a("1bab")),l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-upload",{ref:"my",staticClass:"avatar-uploader",attrs:{"http-request":t.myupload,action:"","auto-upload":!1,"on-success":t.handleAvatarSuccess,"before-upload":t.beforeAvatarUpload,name:"file",limit:"1"}},[t.imageUrl?a("img",{staticClass:"avatar",attrs:{id:"showHead",src:t.imageUrl}}):a("i",{staticClass:"el-icon-plus avatar-uploader-icon"})]),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("上传视频封面图片")]),a("div",{staticClass:"el-upload__tip",attrs:{slot:"tip"},slot:"tip"},[t._v("只能上传jpg文件，且不超过2m")])],1)},d=[],p=(a("d3b7"),a("3ca3"),a("ddb0"),a("2b3d"),{name:"submitImg",data:function(){return{imageUrl:"",Existence:!1}},methods:{remind:function(){alert()},handleAvatarSuccess:function(t,e){console.log(this.imageUrl),this.imageUrl=URL.createObjectURL(e.raw)},beforeAvatarUpload:function(t){if(this.existence)return this.$message.error("不能重复上传"),!1;this.existence=!0;var e="image/jpeg"===t.type,a=t.size/1024/1024<2;return e||this.$message.error("上传头像图片只能是 JPG 格式!"),a||this.$message.error("上传头像图片大小不能超过 2MB!"),e&&a},uploading:function(){this.$refs.my.submit()},myupload:function(t){var e=this,a=new FormData;a.append("file",t.file),Object(r["a"])({url:"/justUplodImg",method:"post",data:a}).then((function(t){console.log(t.data),sessionStorage.setItem("videoImgUrl",t.data),e.imageUrl=t.data})).catch((function(t){console.log(t)}))}},mounted:function(){document.getElementsByClassName(".el-upload")[0].style.border="1px dashed #d9d9d9"}}),u=p,c=(a("e77a"),a("2877")),m=Object(c["a"])(u,l,d,!1,null,"5320b6e8",null),h=m.exports,f={name:"submitVideo",data:function(){return{textarea1:"",textarea2:"",type:"选择视频分类",size:0,quanxain:"选择视频权限",quanxianmsg:["免费","vip视频","收费视频"],showPay:!1,pay:"",jur:0,isUpLoading:!1}},methods:{openFullScreen1:function(){var t=this;this.fullscreenLoading=!0,setTimeout((function(){t.fullscreenLoading=!1}),2e3)},handleInput:function(t){this.pay=t.target.value.replace(/[^\d]/g,"")},handleCommand:function(t){console.log(t),this.type=t},handleCommand2:function(t){this.quanxain=this.quanxianmsg[t],this.jur=t,2==t?this.showPay=!0:this.showPanelColor=!1},uploadReady:function(){this.$refs.submitImg.uploading();var t=this;setTimeout((function(){t.$refs.my.submit()}),1e3)},uploading:function(){""==this.textarea1||""==this.textarea2?this.$message.error("输入内容不能为空"):"选择视频分类"==this.type?this.$message.error("选择视频分类"):this.uploadReady()},myupload:function(t){var e=this,a=new FormData,s=parseInt(sessionStorage.getItem("userId")),o=(new Date).getFullYear()+"-"+((new Date).getMonth()+1)+"-"+(new Date).getDate()+" "+(new Date).getHours()+"时"+(new Date).getMinutes()+"分",i=sessionStorage.getItem("nickName"),n=this.size,l=this.type,d=this.textarea2,p=this.textarea1,u=sessionStorage.getItem("videoImgUrl"),c=this.pay;c=""==this.pay?0:parseInt(this.pay),n=Math.floor(n),a.append("file",t.file),a.append("userName",i),a.append("size",n),a.append("type",l),a.append("time",o),a.append("des",d),a.append("name",p),a.append("imgUrl",u),a.append("id",s),a.append("jur",parseInt(this.jur)),a.append("pay",c),this.isUpLoading=!0,Object(r["a"])({url:"/fileUploadVideo",method:"post",data:a}).then((function(t){e.isUpLoading=!1,console.log(t.data),e.$message({message:"上传成功， 马上进行页面跳转",type:"success"});var a=e;setTimeout((function(){a.$router.replace("/video")}),3e3)})).catch((function(t){console.log(t)}))},beforeAvatarUpload:function(t){var e=t.size/1024/1024<500;return this.size=t.size/1024/1024,e||this.$message.error("上传视频大小不能超过 500MB!"),e}},components:{submitImg:h},created:function(){}},g=f,v=(a("c810"),Object(c["a"])(g,i,n,!1,null,"6297334e",null)),y=v.exports,w={name:"upload-video",components:{submitVideo:y}},b=w,x=(a("6d2f"),Object(c["a"])(b,s,o,!1,null,"4436a540",null));e["default"]=x.exports},3311:function(t,e,a){},"4cc8":function(t,e,a){},"6d2f":function(t,e,a){"use strict";a("92f6")},"92f6":function(t,e,a){},c810:function(t,e,a){"use strict";a("4cc8")},e77a:function(t,e,a){"use strict";a("3311")}}]);
//# sourceMappingURL=chunk-24820074.8250b173.js.map