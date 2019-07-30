import java.net.*
import java.util.*

fun main(args: Array<String>) {
    val port = 3000 // port를 설정합니다.
    val sc : Scanner = Scanner(System.`in`)

    val serverSocket = ServerSocket(port)
    var isStart = true;

    while(true){
        val client = serverSocket.accept() // 서버에 접근한 클라이언트와 통신할 수 있는 소켓을 만듭니다.
        while(client.isConnected) {
            val available = client.inputStream.available() // 데이터가 있으면 데이터의 사이즈 없다면 -1을 반환합니다.

            if(isStart) {
                val data = "서버에 접속하신 것을 환영합니다." // 데이터는 byteArray로 변경 할 수 있어야 합니다.
                client.outputStream.write(data.toByteArray()) // toByteArray() 파라미터로 charset를 설정할 수 있습니다. 기본값 utf-8
                isStart = false;
            }

            if (available > 0){
                val dataArr = ByteArray(available) // 사이즈에 맞게 byte array를 만듭니다.
                client.inputStream.read(dataArr) // byte array에 데이터를 씁니다.
                val data = String(dataArr) // byte array의 데이터를 통해 String을 만듭니다.
                println("data : $data")
                val data2 = sc.next()
                client.outputStream.write(data2.toByteArray())
            }

        }
    }
}