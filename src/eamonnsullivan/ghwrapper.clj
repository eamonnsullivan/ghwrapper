(ns eamonnsullivan.ghwrapper
  (:require [eamonnsullivan.ghsearch :as search]))

(def ^:dynamic *default-page-size* 25)
(def github-url "https://api.github.com/graphql")

(defn get-repos
  "Get information about repos in a given organisation, with the specified topics"
  ([access-token org topics] (search/get-all-pages github-url access-token org topics *default-page-size*))
  ([access-token org topics page-size] (search/get-all-pages github-url access-token org topics page-size)))
