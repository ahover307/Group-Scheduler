const functions = require('firebase-functions');

exports.paymentIntent = functions.https.onCall(async (data, context) => {
    const stripe = require('stripe')('sk_test_v9k8fKhH1oq3R0EnF2vg8n7M00zReeGEZs');

    const paymentIntent = await stripe.paymentIntents.create({
        amount: data.price,
        currency: 'usd',
        payment_method_types: ['card'],
        receipt_email: data.email,
    });

    return paymentIntent.client_secret;
});

exports.grabPrice = functions.https.onCall(async (data) => {
    //data should be the party package
    return 12;
});