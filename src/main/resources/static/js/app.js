paypal.Buttons({
    createOrder: function(data, actions) {
        return actions.order.create({
            purchase_units: [{
                amount: {
                    value: '120.0' // Precio del curso
                }
            }]
        });
    },
    onApprove: function(data, actions) {
        return actions.order.capture().then(function(orderData) {
            //document.getElementById('result-message').innerText = 'Pago completado por ' + details.payer.name.given_name;
            alert('transacción exitosa')
            console.log(orderData)
        });
    }
}).render('#paypal-button-container');
