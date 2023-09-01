curl -X 'POST' \
  'http://localhost:9080/compra/' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "items": [
    {
      "quantidade": 1,
      "identificadorItem": "1",
      "combo": true
    },
{
      "quantidade": 2,
      "identificadorItem": "2",
      "combo": false
    }
  ],
  "formaPagamento": {
    "tipoPagamento": "PIX"
  },
  "identificador_cliente": "00000000000"
}'