リンク：https://memoweb.onrender.com/memoweb

# 開発環境
Eclipse ver.2023で作成しました。

言語はJava、データベースはMySQLを使用しています。  
(Renderでデプロイをしたので実行環境ではPostgreSqlを使用しています）

ハンバーガーメニューとモーダルウィンドウの実装のためにJavaScriptを使用しています。

フレームワークは使用せず、動的Webプロジェクトで作成しています。

XSS対策としてJSTLを使用しています。

# 主な機能
## 共通機能
 - 各種入力チェックのバリデーション  
   動的配列にエラーメッセージを格納して、それぞれエラーメッセージを出力

 - ログインしているかどうかの検査  
   ログインをせずホーム画面に移ろうとすると検査をして、デフォルトページへリダイレクトさせる

## アカウント作成、削除
 - ユーザーIDの重複を許さないように検査を実装  
   同じユーザーIDが存在する場合エラーを表示
 
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

 https://github.com/Tsaito-H13/memoApp/assets/159527566/34e1b88f-5085-49af-8519-e67b252d779a

 **ログイン**

 https://github.com/Tsaito-H13/memoApp/assets/159527566/983146d5-5009-47b2-8887-0802b85d211f

 **メモ作成、編集、削除**

 https://github.com/Tsaito-H13/memoApp/assets/159527566/6ce7976a-1a6b-4932-91ac-fefd4ab408f3

 https://github.com/Tsaito-H13/memoApp/assets/159527566/88937992-c1cc-43ea-9855-136b5aa2ebc3

 **ログアウト、アカウント削除**

 https://github.com/Tsaito-H13/memoApp/assets/159527566/f7b2914a-ce57-4a2c-9c22-6857acb71416
