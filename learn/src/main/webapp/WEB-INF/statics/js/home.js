function doPost(url,succ){
    doRequest(url,'POST',succ);
}
function doGet(url,succ){
    doRequest(url,'GET',succ);
}
function doRequest(url,type,succ){
     $.ajax({type:type,url:url,success:function(resp){
        if(succ){
            succ(resp)
        }else{
            location.reload()
        }
     },error:function(resp){
         $.alert({
             title: 'Error',
             content: resp.responseText,
         })
     }})
}

function scan(env){
    if(!confirm('Are you sure?')){
        return;
    }
    doPost('/at/scan/'+env);
}

function setBase(scanId,env){
    $.confirm({
        title: 'Confirm',
        content: 'Set base for env:'+env,
        buttons: {
            confirm: function () {
                doPost('/at/base/'+scanId+'/'+env)
            },
            cancel: function () {
//                $.alert('Canceled!');
            },
            somethingElse: {
                text: 'Set Base & Clean',
                btnClass: 'btn-red',
                action: function(){
                    doPost('/at/base/'+scanId+'/'+env+'?clean=1')
                }
            }
        }
    });
}
function createReport(scanId){
    doPost('/at/report/'+scanId)
}
