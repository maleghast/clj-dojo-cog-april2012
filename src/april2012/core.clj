(ns april2012.core
  (:use quil.core))
  
  (defn fib
    [a b]
    (cons a (lazy-seq (fib b (+ a b)))))
  
  (defn setup []
    (smooth)                          ;;Turn on anti-aliasing
    (frame-rate 1)                    ;;Set framerate to 1 FPS
    (background 200))                 ;;Set the background colour to
                                      ;;  a nice shade of grey.
  (defn draw []
    (stroke (random 255))             ;;Set the stroke colour to a random grey
    (stroke-weight (random 10))       ;;Set the stroke thickness randomly
    (fill 255 0 0 100)               ;;Set the fill colour to a random grey

    (let [fibs (take 10 (fib 1 1))]         ;;Set the x coord randomly within the sketch
      (println fibs)
      (doseq[x fibs]
        (rect (* 10 x) (* 10 x) (* 10 x) (* 10 x))
        (arc (* 10 x) (* 10 x) (* 10 x) (* 10 x) 0 30))))
    
  (defsketch example                  ;;Define a new sketch named example
    :title "Oh so many grey squares"  ;;Set the title of the sketch
    :setup setup                      ;;Specify the setup fn
    :draw draw                        ;;Specify the draw fn
    :size [800 640])                  ;;You struggle to beat the golden ratio