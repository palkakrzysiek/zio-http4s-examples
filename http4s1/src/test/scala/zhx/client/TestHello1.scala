package zhx.client

import org.http4s._
import zio.{IO, RIO, Task, ZIO}
import zio.test.Assertion.equalTo
import zio.test.{DefaultRunnableSpec, assert, assertM, suite, testM}



object TestHello1 extends DefaultRunnableSpec(

  suite("routes suite")(
    testM("test get") {
      ClientTest.testClientM { client =>
        val req = Request[Task](Method.GET, uri"http://localhost:8080/")
        assertM(client.status(req), equalTo(Status.Ok))
      }
    }
  )

)