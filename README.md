# API詳細
コーディング規約に準拠したサンプルAPI

# コードフォーマット
IntelliJのプラグインのgoogle-java-formatを利用
初期設定では動かないので以下参考
https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config

# IF仕様書
http://localhost:8080/swagger-ui/index.html

# コーディング規約
## ディレクトリ構成
```
- presentation/
  - controller/
  - dto/
    - request/
    - response/
  - helper/
  - exception/
- application/
  - service/
  - exception/
- domain/
  - model/
  - exception/
  - service/
  - repository/
  - validate/
  - value/
  - const/
- repository
  - api
    - config
    - dto
      - request
      - response
    - impl
    - exception
  - database
    - mapper
      - dto
        - request
        - response
      - exception
      - impl
```
## 各説明
- <span>presentation<span> <br>ユーザーインターフェースとの接触面を実装するためのパッケージです。この層では、ユーザーが直接触れる部分を担当しており、UIや入力値のバリデーションなどの責任を持ちます。これらはドメインロジックから独立して実装され、ビジネスルールを保持するためのDTOを介して、ドメイン層とやり取りを行います。
  - <span>controller<span> <br>リクエストを受け取り、ビジネスロジックを実行し、レスポンスを返すためのパッケージです。コントローラーは、presentation層とbusiness層の間の架け橋の役割を担い、ドメイン層から受け取ったDTOをもとにビジネスロジックを呼び出します。また、DTOに応じたレスポンスを生成し、クライアントに返します。
  - <span>dto<span> <br>外部とのやり取りのためのDTOを実装するパッケージです。DTOはData Transfer Objectの略であり、外部との通信に必要なデータを表現します。ビジネスロジックからはDTOを介してデータを受け渡します。この層では、入力DTOと出力DTOを用意して、それぞれのDTOに必要なフィールドやバリデーションルールを定義します。
    - <span>request<span> <br>リクエスト用のDTOを実装するパッケージです。クライアントから受け取ったリクエスト情報を表現するDTOを用意します。必要なデータやバリデーションルールは、このパッケージ内で定義します。
    - <span>response<span> <br>レスポンス用のDTOを実装するパッケージです。レスポンス情報を表現するDTOを用意します。必要なデータやバリデーションルールは、このパッケージ内で定義します。
  - <span>helper<span> <br>クライアントにリクエスト/レスポンスを返すためのヘルパーを実装するパッケージです。この層では、DTOを加工したり、例外をハンドリングしたりするためのユーティリティを実装します。
  - <span>exception<span> <br>presentation層で発生した例外を処理するためのパッケージです。入力値が不正などの場合に発生する例外をキャッチし、エラーメッセージを生成してクライアントに返すための実装を行います。
- <span>application</span><br>
  applicationは、presentation層とdomain層の仲介を行うアプリケーション固有のビジネスロジックを担当する層です。以下に詳細を示します。
  - <span>service</span><br>
    application層における、ビジネスロジックの処理の振る舞いを実装するクラスです。@Serviceアノテーションを付与して実装します。この層では、具体的なビジネスロジックを実装するのではなく、ドメインロジックを組み合わせてアプリケーション固有のビジネスロジックを実現します。
  - <span>exception</span><br>
    application層で発生した例外を実装するパッケージです。この層で発生した例外は、presentation層に渡され、クライアントに適切なエラーレスポンスを返すために使用されます。例外の種類によって、異なるエラーコードが返されるようにします。また、例外のログ出力もこの層で行います。
- <span>domain</span><br>業務ロジックや業務の関心ごとを実装するパッケージです。ドメイン層は、ビジネスロジックを表現し、アプリケーションの要件に合わせて構成されます。ドメインモデルを中心に、ドメインサービス、値オブジェクト、例外、共通のバリデーション、Enumなどが実装されます。
  - <span>model</span><br>ビジネスロジックを持つモデルクラスを実装するパッケージです。ドメインモデルは、アプリケーションが扱うビジネスロジックの本質を表現します。この層で実装されるモデルは、イミュータブルであり、Getter/Setterは禁止されています。モデルが持つビジネスルールは、この層で厳密に守られます。
  - <span>exception</span><br>domain層で発生した例外を実装するパッケージです。ドメイン層で発生する例外は、ドメインモデルの制約によるものが多く、それらを表現するための例外クラスを定義します。
  - <span>service</span><br>ドメインサービスを実装するパッケージです。ドメインサービスは、複数のドメインオブジェクトを組み合わせて行う操作や、業務に関する処理の流れを制御するために使用されます。
  - <span>repository</span><br>ドメインモデルの永続化を実装するパッケージです。リレーショナルデータベースやNoSQLデータベース、外部APIなど、永続化の対象に応じて実装が異なります。I/Fクラスを実装することで、他の層からのアクセスを提供します。
  - <span>validate</span><br>ドメインモデルの共通のバリデーションを実装するパッケージです。ドメインモデルが持つべき共通ルールは、この層で定義され、モデルから独立して再利用可能なバリデーションコードとして提供されます。
  - <span>value</span><br>値オブジェクトを実装するパッケージです。値オブジェクトは、単一の値を表現する不変なオブジェクトであり、その値に関連するビジネスルールを持ちます。値オブジェクトは、エンティティとは異なり、識別子を持たず、同じ値を持つオブジェクトは等価とみなされます。例えば、日付、金額、郵便番号などが値オブジェクトとして実装されます。値オブジェクトは、不変性を保証するためにSetterを持たず、コンストラクタで初期化されます。
  - <span>const</span><br>Enumを実装するパッケージです。Enumは、定数の集合体を表現するためのJavaの機能であり、DDDの定数に相当します。例えば、性別、曜日、商品カテゴリなどがEnumとして実装されます。Enumは、値オブジェクトと同じく不変性を保証するため、Setterを持ちません。また、Enumは単一のインスタンスしか持たず、そのインスタンスはプログラム全体で共有されます。これにより、Enumを使うことで、定数の値を一元管理することができます。
- <span>repository</span><br>DBや外部APIのアクセスを実装します。
  - <span>api</span><br>外部APIのアクセスを実装するためのパッケージです。外部APIに対応したクライアントを実装し、リクエスト/レスポンスのマッピング処理などを行います。
    - <span>config</span><br>外部APIに対応した設定を実装するためのパッケージです。APIキーなどの認証情報やエンドポイントなどの設定を記述します。
    - <span>dto</span><br>外部APIとのやり取りのためのDTOを実装するパッケージです。リクエストDTOとレスポンスDTOを定義し、APIとのやり取りに使用します。
      - <span>request</span><br>外部APIへのリクエストDTOを実装するパッケージです。APIに送信するデータを表現します。
      - <span>response</span><br>外部APIからのレスポンスDTOを実装するパッケージです。APIから受信するデータを表現します。
    - <span>impl</span><br>外部APIとのやり取りを実装するクライアントを実装するパッケージです。実際にAPIにアクセスし、レスポンスを受信してDTOにマッピングする処理を実装します。
    - <span>exception</span><br>外部APIとの通信に関する例外を実装するパッケージです。APIとの通信に失敗した場合に発生する例外を実装します。
  - <span>database</span><br>データベースのアクセスを実装するためのパッケージです。データベースに対応したDAO（Data Access Object）を実装し、SQL文の発行やレコードのマッピングなどの処理を行います。
    - <span>mapper</span><br>マッパーを実装するためのパッケージです。MyBatisなどのORM（Object-Relational Mapping）フレームワークを使用する場合には、mapperと呼ばれるXMLファイルを記述します。
      - <span>dto</span><br>データベースとのやり取りのためのDTOを実装するパッケージです。リクエストDTOとレスポンスDTOを定義し、データベースとのやり取りに使用します。
        - <span>request</span><br>データベースへのリクエストDTOを実装するパッケージです。データベースに送信するデータを表現します。
        - <span>response</span><br>データベースからのレスポンスDTOを実装するパッケージです。データベースから受信するデータを表現します。
      - <span>exception</span><br>database層で発生した例外を実装
      - <span>impl</span><br>データベースとの通信に関する例外を実装
