function validateAccount(){
	var documentFrom = $('#documentFrom').val();
	var agencyCodeFrom = $('#agencyCodeFrom').val();
	var accountNumberFrom = $('#accountNumberFrom').val();
	var isNull = false;
	
	$('input').each(function(index){
		if($('input')[index].value == ""){
			$('input')[index].style.border = "1px solid red";
			isNull = true;
		}else{
			$('input')[index].style.border = "1px solid #ccc";
		}
	});
	
	if(isNull){
		alert("Preencha os campos em vermelho");
	}else{
		$.ajax({
		      type: 'get',
		      data: 'document='+documentFrom+'&agencyCode='+agencyCodeFrom+'&accountNumber='+accountNumberFrom+'',
		      url:'http://localhost:8080/bluebank/rest/services/findAccountant',
		      async: false,
		      success: function(data){
		    	  window.location.href = "http://localhost:8080/bluebank/transfer.html";
		    	  var params = {"document": data.Document,"name": data.Name, "agencyCode": data.AgencyCode, "accountNumber": data.AccountNumber, "balanceAvailable": data.BalanceAvailable}
		    	  var dados = JSON.stringify(params);
		    	  sessionStorage.setItem('id', dados );
		      },
		      error: function (data){
	              alert("Dados Inválido");
	          }
		});
	}
}

function clean(){
	$('input').each(function(index){
		$('input')[index].value = "";
	});
	sessionStorage.clear();
}
