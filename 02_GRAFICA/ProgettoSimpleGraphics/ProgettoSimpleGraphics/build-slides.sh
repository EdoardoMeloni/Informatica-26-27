#!/bin/bash
pandoc slides.md \
  -t revealjs \
  -s \
  -o slides.html \
  --slide-level=2 \
  -V theme=solarized \
  -V revealjs-url=https://cdn.jsdelivr.net/npm/reveal.js@4 \
  -V width=1280 \
  -V height=720 \
  -V margin=0.1 \
  -V controls=true
