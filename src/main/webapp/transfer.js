var data;

function fillInData(){
	data = JSON.parse(sessionStorage.getItem('id'));
	$('#nameFrom').val(data.name);
	$('#agencyCodeFrom').val(data.agencyCode);
	$('#accountNumberFrom').val(data.accountNumber);
	$('#balanceAvailableFrom').val(maskMoneyConvertString(data.balanceAvailable));
}

function transfer(){
	var isNull = false;
	$('[data-transfer]').each(function(index){
		if($('[data-transfer]')[index].value == ""){
			$('[data-transfer]')[index].style.border = "1px solid red";
			isNull = true;
		}else{
			$('[data-transfer]')[index].style.border = "1px solid #ccc";
		}
	});
	
	if(isNull){
		alert("Preencha os campos em vermelho");
	}else{
		var documentTo = $('#documentTo').val();
		var agencyCodeTo = $('#agencyCodeTo').val();
		var accountNumberTo = $('#accountNumberTo').val();
		var transferValue = Number($('#transferValue').val());
		
		var idFrom = Number(findId(data.document, data.agencyCode, data.accountNumber));
		var idTo = Number(findId(documentTo, agencyCodeTo, accountNumberTo));
		
		var params = {"AccountantFromId": idFrom, "AccountantToId" : idTo, "TransferValue": transferValue}
		
		$.ajax({
			type: 'post',
			url:'http://localhost:8080/bluebank/rest/services/doTransfer',
			contentType:"application/json; charset=uft-8",
			data: JSON.stringify(params),
			dataType: "json",
			async: false,
			success: function(data,textStatus,jqXHR){
				alert(data.Message);
			},
			 error: function (data){
	             console.log(data);
	         }
		});
	}
}

function findId(doc, agencyCode, accountNumber){
	var retorno;
	$.ajax({
	      type: 'get',
	      data: 'document='+doc+'&agencyCode='+agencyCode+'&accountNumber='+accountNumber+'',
	      url:'http://localhost:8080/bluebank/rest/services/findAccountant',
	      async: false,
	      success: function(data){
	    	  retorno = data;
	      },
	      error: function (data){
              console.log(data);
          }
	})
	return retorno.Id;
}

function exit(){
	window.location.href = "http://localhost:8080/bluebank/entry.html";
}

function maskMoneyConvertString (value){
	value= ""+value;
	var sep = 0;
  	var splits = value.split(".");
  	if(splits.length > 1){
  		var beforeDot= splits[0];
  		var afterDot = splits[1];
  		var afterDotPrecision = afterDot.substring(0, 2);
  		if ((afterDotPrecision <= 9) &&(afterDotPrecision > 0) && (afterDotPrecision.length < 2)){
  			afterDotPrecision += "0";
  		}
  		value = beforeDot + afterDotPrecision;
  	}else {
  		value+="00";
  	}
  		
    var i = j = 0;
    var len = len2 = 0;
    var aux = aux2 = '';
   // Valor para o código da Chave
    aux += value;
    len = aux.length;
    if (len > 2) {
        aux2 = '';
        for (j = 0, i = len - 3; i >= 0; i--) {
            if (j == 3) {
                aux2 += '.';
                j = 0;
            }
            aux2 += aux.charAt(i);
            j++;
        }
        value = '';
        len2 = aux2.length;
        for (i = len2 - 1; i >= 0; i--)
        value += aux2.charAt(i);
        value += ',' + aux.substr(len - 2, len);
    }
    return value;
}