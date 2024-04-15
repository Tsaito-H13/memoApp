# 開発環境
Eclipse ver.2023で作成しました。

言語にはJavaを使用、データベースはMySQLを使用しました。

フレームワークは使用せず、動的Webプロジェクトで作成しています。

# 主な機能
## 共通機能
 - 各種入力チェックのバリデーション
 
 - 動的配列にエラーメッセージを格納して、それぞれエラーメッセージを出力

 - ログインしているかどうかの検査

　（ログインをせずホーム画面に移ろうとすると検査をして、デフォルトページへリダイレクトさせる）

## アカウント作成、削除
 - ユーザーIDの重複を許さないため、検査を実装
 
 - パスワードはハッシュ化したものを保存
 
 - 削除では、フォームで入力したパスワードとセッションスコープに保存されたユーザーIDを

   hiddenフィールドで送信して該当するものを選択して削除
 
## ログインとログアウト
 - セッションスコープにログイン情報を格納したインスタンスを保存する
 - ログアウトを行うとセッションスコープを破棄する

## メモの作成と削除と編集
 - 論理削除と物理削除を実装
 - メモ一覧からメモの一覧と編集を行える
 - 論理削除したものは削除したメモ一覧から復元が可能

   削除したメモ一覧から削除をすると物理削除できる

# 実行動作
 **アカウント作成**
 
https://github.com/Tsaito-H13/memoApp/assets/159527566/98b873b9-b14e-4e44-b095-469dbe478703

 **ログイン**

https://github.com/Tsaito-H13/memoApp/assets/159527566/6b6deef9-be04-45eb-8503-36c76cc34c87

 **メモ作成、編集、削除**

https://github.com/Tsaito-H13/memoApp/assets/159527566/ca558bfd-315c-4624-a5f0-9767d100765b

https://github.com/Tsaito-H13/memoApp/assets/159527566/13528a86-d441-4cd9-9195-6ee24ea41eae

https://github.com/Tsaito-H13/memoApp/assets/159527566/e5ac5948-4333-4d00-acd8-a477d51f5d15

 **ログアウト、アカウント削除**

https://github.com/Tsaito-H13/memoApp/assets/159527566/e72ebb58-ca95-4fb0-9e56-18e37f800b55
