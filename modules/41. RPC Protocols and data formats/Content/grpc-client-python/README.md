# Instructions

Install dependencies
```shell
pip install -r requirements.txt
```

Re-generate GRPC protocol wrappers:
(see [grpcio-tools](https://pypi.org/project/grpcio-tools/))

```shell
python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. ping-pong.proto
```

Start server from `../grpc-server/`.

Run the client
```
python3 grpc-client.py
```

