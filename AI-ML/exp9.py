from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import classification_report

texts = ["The food was excellent.", "The service was impeccable.", "The atmosphere was inviting.", "I had a wonderful dining experience.", "I highly recommend this restaurant.", "The movie was boring and predictable.", "The acting was subpar.", "The plot was unoriginal.", "I was disappointed with the film.", "I would not recommend this movie.", "I'm feeling grateful for my family and friends.", "I'm appreciative of their love and support.", "I'm blessed to have them in my life.", "I'm thankful for their presence.", "I'm happy to have them as my family and friends."]
labels = ["Positive", "Positive", "Positive", "Positive", "Positive", "Negative", "Negative", "Negative", "Negative", "Negative", "Positive", "Positive", "Positive", "Positive", "Positive"]

# Text Vectorization
vectorizer = CountVectorizer(stop_words='english')
X = vectorizer.fit_transform(texts)

# Building and training the Naïve Bayes Model
nb_classifier = MultinomialNB()
nb_classifier.fit(X, labels)



# Predicting sentiment of a new text
new_text = ["I am loving it."]
new_text_vectorized = vectorizer.transform(new_text)
prediction = nb_classifier.predict(new_text_vectorized)

print(f"Prediction for the new text: {prediction[0]}")
