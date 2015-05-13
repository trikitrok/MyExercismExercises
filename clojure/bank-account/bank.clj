(ns bank-account)

(defn open-account []
  (atom 0))

(defn close-account [_])

(defn get-balance [acct]
  @acct)

(defn update-balance [account amount]
  (swap! account + amount))