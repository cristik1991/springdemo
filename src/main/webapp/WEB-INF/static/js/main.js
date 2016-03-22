$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function checkList(form,names){
    for(key in form){
        var list = new Array();
        for(var i=0;i<names.length;i++){
            var name =names[i];
            if(key==name){
                if(!isArray(form[key])){
                    if(form[key]!=null||form[key]!=''){
                        list.push(form[key]);
                    }
                    delete form[name];
                    form[name]=list;
                }
            }
        }
    }
    return form;
}

function isArray(obj) {
    return Object.prototype.toString.call(obj) === '[object Array]';
}
