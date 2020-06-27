(ns eamonnsullivan.ghwrapper-test
  (:require [clojure.test :refer :all]
            [eamonnsullivan.ghsearch :as search]
            [eamonnsullivan.ghwrapper :as sut]))

(defn fake-all-pages
  [_ _ _ _ page-size]
  (let [response {}]
    (deftest testing-arguments
      (testing "gets called with page-size set"
        (is (= 2 page-size))))
    response))

(deftest testing-get-repos
  (with-redefs [search/get-all-pages fake-all-pages]
    (testing "can override page-size"
      (sut/get-repos "secret-token" "org" ["topic1" "topic2"] 2))))
